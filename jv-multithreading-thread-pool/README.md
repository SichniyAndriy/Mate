# Thread pool

Create in `main()` method an `ExecutorService` instance with a fixed-sized thread pool for 5 threads.
Then add 20 threads of type `MyThread` to your `ExecutorService`. 
Let's add `Future` objects that we receive to the `futures` list.

Your threads should return a `String` in the following format:
```Task duration was 200 ms, execution finished at 11:27:47.243785```

Task duration means that your thread should actually be suspended for this period.
You can randomly generate task duration for each thread and use `LocalTime.now()` 
to get the time when this thread finishes execution. 

After all your tasks are executed, in `main()` method log the result string from each `Future` in `futures` list.

Note that you should push the file with logs to your PR, so please, do not add it to `.gitignore`.
You may probably need to use the absolute path to the log file in `log4j2.xml`.

Logs example:
```
INFO core.basesyntax.Main:24 Task duration was 200 ms, execution finished at 11:27:47.243785
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:47.358773
INFO core.basesyntax.Main:24 Task duration was 200 ms, execution finished at 11:27:47.562603
INFO core.basesyntax.Main:24 Task duration was 300 ms, execution finished at 11:27:47.865479
INFO core.basesyntax.Main:24 Task duration was 500 ms, execution finished at 11:27:48.367833
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:48.470337
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:48.574946
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:48.677488
INFO core.basesyntax.Main:24 Task duration was 500 ms, execution finished at 11:27:49.181528
INFO core.basesyntax.Main:24 Task duration was 200 ms, execution finished at 11:27:49.391357
INFO core.basesyntax.Main:24 Task duration was 400 ms, execution finished at 11:27:49.796201
INFO core.basesyntax.Main:24 Task duration was 400 ms, execution finished at 11:27:50.197847
INFO core.basesyntax.Main:24 Task duration was 300 ms, execution finished at 11:27:50.500033
INFO core.basesyntax.Main:24 Task duration was 400 ms, execution finished at 11:27:50.901827
INFO core.basesyntax.Main:24 Task duration was 400 ms, execution finished at 11:27:51.303852
INFO core.basesyntax.Main:24 Task duration was 500 ms, execution finished at 11:27:51.807451
INFO core.basesyntax.Main:24 Task duration was 500 ms, execution finished at 11:27:52.310309
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:52.412642
INFO core.basesyntax.Main:24 Task duration was 100 ms, execution finished at 11:27:52.519061
INFO core.basesyntax.Main:24 Task duration was 200 ms, execution finished at 11:27:52.722007
```
