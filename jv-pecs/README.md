# jv-pecs

1. You have abstract class `Machine` and three sub-classes: `Bulldozer`, `Excavator` and `Truck`. Feel free to add some type-specific fields to these classes.
1. Each machine has the ability to start working.
1. There is MachineProducer interface created.
The goal of implementation of this interface is to create a list of specific machines (`Bulldozer`, `Excavator` and `Truck`). 
You should have at least 3 implementations: `BulldozerProducer`, `ExcavatorProducer`, `TruckProducer`;
Please parameterize your `MachineProducer` and replace `Object` in `get()` with the suitable option.
    ```java
    public interface MachineProducer<PARAMETRIZE ME>{ ... }
    ```
1. In `MachineProducer` implementations your method `get()` should return the list of specific machines. 
For example: 
    ```java
    List<Bulldozer> get();
    ```
    or 
    ```java
    List<Truck> get();
    ```
    or 
    ```java
    List<Excavator> get();
    ```

1. There is also `MachineService` interface created. You need to parameterize it as well and 
replace `Object` in method signature with the right option (use PECS):

    - the method `getAll(Class type)` produces the list of machines based on the input param.
    - the method `fill(List<Object> machines, Object value)` fills the machines list with passed value.
    - the method `startWorking()` should be able to accept a list containing any Machine.

When you parameterize interface `MachineService` keep in mind that we want to restrict types that can be used with it.

Not allow:  
~~`MachineServiceImpl implements MachineService<Dog>`~~  
Allow:  
`MachineServiceImpl implements MachineService<Truck>`  
``
1. Use the created class `MachineServiceImpl` implementing MachineService and realize these methods:
- `getAll(Class type)`- based on the input class type, choose the right MachineProducer implementation and call its `get()` method.

For example: `if (type == Bulldozer.class)` - we should call the `get()` method from right implementation of MachineProducer (the one that will return `List<Bulldozer>`) and return these machines.

- `fill(List<Object> machines, Object value)` - update to the passed value (**which can be of any Machine subtype**) all elements in the `machines` list.

- `startWorking()` - call `doWork` on every Machine in the list.

#### [Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/pecs/pecs.html)
