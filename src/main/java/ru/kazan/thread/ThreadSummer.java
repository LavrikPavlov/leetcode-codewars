package ru.kazan.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSummer {

    private static final Logger log = LoggerFactory.getILoggerFactory().getLogger(ThreadSummer.class.getName());
    private static final AtomicInteger number = new AtomicInteger(0);
    private static final Random rd = new Random();
    private static final ConcurrentLinkedQueue<Integer> queque = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        var service = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            list.add(getThreadRun());
        }
        log.info("Потоков вв листе: {}", list.size());
        Thread.sleep(5000);
        log.info("Запуск");
        List<Future<Integer>> futures = service.invokeAll(list);
        service.shutdown();

        for (Future<Integer> num : futures)
            log.info("Результат {} выполен - {}", num.get(), num.isDone());

        System.out.println("Программа завершилась с числом: " + number.get());

        Integer sum = 0;
        log.info("Очерель из чисел {}", queque);

        while (!queque.isEmpty())
            sum += queque.poll();

        System.out.println("Полная сумма в одном потоке: " + sum);


    }

    private static Callable<Integer> getThreadRun(){
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("Запущен поток: {}", Thread.currentThread().getName());
                var random  = rd.nextInt(100);
                queque.add(random);
                return number.getAndAdd(random);
            }
        };
    }
}
