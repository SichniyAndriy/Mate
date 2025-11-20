# Decrease counter

We wrote multi-threaded code that decreases the value of the `Counter` object.
In `main()` method, 20 threads are created that accept the same `Counter` object.
The task of each thread is to decrease the value of the `counter` by 1.

The original `counter` value is 20, so we should expect 0 in the end.

We are logging the value before and after each decrement, and now we see that the results are hardly consistent.

```
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 15, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  8, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 12, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 18, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 14, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  5, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  7, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  9, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 11, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  3, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  6, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 17, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  2, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 10, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 19, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 20, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 16, counter value 20
INFO core.basesyntax.Counter:16  Before decrementing, Thread # 13, counter value 20
INFO core.basesyntax.Counter:19   After decrementing, Thread #  7, counter value 12
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  1, counter value 20
INFO core.basesyntax.Counter:19   After decrementing, Thread #  3, counter value 16
INFO core.basesyntax.Counter:19   After decrementing, Thread # 20, counter value 10
INFO core.basesyntax.Counter:19   After decrementing, Thread # 19, counter value  9
INFO core.basesyntax.Counter:19   After decrementing, Thread #  5, counter value 17
INFO core.basesyntax.Counter:19   After decrementing, Thread #  2, counter value 12
INFO core.basesyntax.Counter:19   After decrementing, Thread #  8, counter value 18
INFO core.basesyntax.Counter:19   After decrementing, Thread #  9, counter value 18
INFO core.basesyntax.Counter:19   After decrementing, Thread # 14, counter value 15
INFO core.basesyntax.Counter:19   After decrementing, Thread # 10, counter value 14
INFO core.basesyntax.Counter:19   After decrementing, Thread # 17, counter value 11
INFO core.basesyntax.Counter:19   After decrementing, Thread # 16, counter value  8
INFO core.basesyntax.Counter:16  Before decrementing, Thread #  4, counter value 20
INFO core.basesyntax.Counter:19   After decrementing, Thread # 11, counter value 18
INFO core.basesyntax.Counter:19   After decrementing, Thread # 12, counter value  5
INFO core.basesyntax.Counter:19   After decrementing, Thread #  6, counter value  6
INFO core.basesyntax.Counter:19   After decrementing, Thread # 13, counter value  7
INFO core.basesyntax.Counter:19   After decrementing, Thread # 18, counter value  4
INFO core.basesyntax.Counter:19   After decrementing, Thread #  4, counter value  3
INFO core.basesyntax.Counter:19   After decrementing, Thread # 15, counter value  2
INFO core.basesyntax.Counter:19   After decrementing, Thread #  1, counter value  1
```

As we see, all threads are accessing the same value of the variable at the same time, 
then they also decrease it randomly, and we can even get 1 instead of 0 in the end of execution.

Fix the solution to remove the race condition between the threads.
Each thread should take the value that was decremented by the previous thread, and the logs should be consistent.
Let's allow only one thread to execute the meaningful part of code at a time.

Note that you should push the file with logs to your PR, so please, do not add it to `.gitignore`.
You may probably need to use the absolute path to the log file in `log4j2.xml`.
