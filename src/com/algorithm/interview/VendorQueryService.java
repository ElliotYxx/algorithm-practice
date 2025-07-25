package com.algorithm.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: Elliot
 * @Date: 2025-07-25 11:21
 * @Description: todo
 **/
public class VendorQueryService {

    public class Vendor{
        private Long id;
        private String name;
        // ms
        private Long latency;
        public Vendor(Long id, String name, Long latency) {
            this.id = id;
            this.name = name;
            this.latency = latency;
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

        public Long getLatency() {
            return latency;
        }

        public void setLatency(Long latency) {
            this.latency = latency;
        }
    }

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public List<Vendor> queryVendorResource(long rt) throws InterruptedException, ExecutionException, TimeoutException {
        // mock vendor resource
        List<Vendor> vendorResource = List.of(
                new Vendor(1L, "resource1", 10L),
                new Vendor(1L, "resource2", 20L),
                new Vendor(2L, "resource3", 30L)
        );
        List<Future<Vendor>> futures = new ArrayList<>();
        for (Vendor vendor : vendorResource) {
            Future<Vendor> future = executorService.submit(() -> {
                try {
                    // mock call vendor service by thread.sleep()
                    Thread.sleep(vendor.getLatency());
                    return vendor;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            });
            futures.add(future);
        }

        List<Vendor> resultList = new ArrayList<>();
        for (Future<Vendor> future : futures) {
            Vendor vendor = future.get(rt, TimeUnit.MILLISECONDS);
            if (vendor != null) {
                resultList.add(vendor);
            }
        }
        return resultList;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        VendorQueryService service = new VendorQueryService();
        service.queryVendorResource(50);
    }

}

