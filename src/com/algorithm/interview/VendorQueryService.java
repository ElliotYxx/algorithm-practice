package com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: Elliot
 * @Date: 2025-07-25 11:21
 * @Description: todo
 * 用 java 代码写一个 queryVendorResource 方法，在规定的 RT 范围内，拿到符合性能要求的供应商资源
 **/
public class VendorQueryService {

    public class Vendor{
        private Long id;
        private String name;
        // milliseconds
        private Long responseTimeMs;
        public Vendor(Long id, String name, Long responseTimeMs) {
            this.id = id;
            this.name = name;
            this.responseTimeMs = responseTimeMs;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getResponseTimeMs() {
            return responseTimeMs;
        }

        public void setResponseTimeMs(Long responseTimeMs) {
            this.responseTimeMs = responseTimeMs;
        }

        public String toString() {
            return "Vendor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", responseTimeMs=" + responseTimeMs +
                    '}';
        }
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public List<Vendor> queryVendorResource(long rt) {
        // mock vendor resource
        List<Vendor> vendorResource = List.of(
                new Vendor(1L, "resource1", 100L),
                new Vendor(2L, "resource2", 150L),
                new Vendor(3L, "resource3", 300L)
        );
        List<CompletableFuture<Vendor>> futureList = new ArrayList<>();
        List<Vendor> resultList = new ArrayList<>();

        for (Vendor vendor : vendorResource) {
            CompletableFuture<Vendor> future = CompletableFuture.supplyAsync(() -> {
                try {
                    // mock fetch vendor resource
                    Thread.sleep(vendor.getResponseTimeMs());
                    return vendor;
                } catch (Exception e) {
                    // handle exception
                    System.out.println("Error occurred while querying vendor: " + e.getMessage());
                }
                return null;
            }, executorService)
            .orTimeout(rt, TimeUnit.MILLISECONDS)
            .exceptionally(e -> {
                // handle timeout or other exceptions
                System.out.println("exception occurred while querying vendor: " + vendor.getName());
                return null;
            });
            futureList.add(future);
        }

        try {
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
            for (CompletableFuture<Vendor> future : futureList) {
                try {
                    Vendor vendor = future.get();
                    if (vendor != null) {
                        resultList.add(vendor);
                    }
                } catch (Exception e) {
                    // handle exception
                    System.out.println("Error occurred while querying vendor: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // handle exception
            System.out.println("Error occurred while querying vendor: " + e.getMessage());
        }finally{
            // shutdown the executor
            executorService.shutdown();
        }
        return resultList;
    }


    public static void main(String[] args) throws Exception {
        VendorQueryService service = new VendorQueryService();
        List<Vendor> resultList = service.queryVendorResource(150);
        // should be vendor1 and vendor2
        resultList.forEach(System.out::println);
    }

}

