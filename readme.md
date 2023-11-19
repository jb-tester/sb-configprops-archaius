
# Attempt to use Spring Boot with Archaius2 configuration interfaces

[IDEA-338307](https://youtrack.jetbrains.com/issue/IDEA-338307)

`ArchInterface`, `DummyInterface` and `BooInterface` are the Archaius2 configuration interfaces
that define the properties. All these interfaces are registered as Spring Beans in the `BeansConfig` class.



the controller `MyController` gets the property values:

1. The properties defined in `ArchInterface` are taken from the injected interfaces itself (`test1()` method). The property value is
set in the `application.properties` where it is shown (falsely) as not resolved.
2. The `DummyInterface` is used as a type of the Map-type property in the SB configuration properties class `MyConfigPropsThatUseArchaiusConfigAsMapValue`.
 The dummyInterface bean  is injected to this class just to populate the default value for the Map.
The value of this map property is set in the `application.properties` where it is resolved, but attempt to get it in the controller `test2()` method
returns the default value: the property is not really set.
3. The `BooInterface` is used as a type of the `@NestedConfigurationProperty`-annotated property in the SB configuration properties class `MyConfigPropsThatUseArchaiusConfigAsNestedCP`.
   This property also injects the `booInterface` bean there. The configuration class uses the same property prefix as the interface does, and thus the 
   property value is read from the `application.properties` normally - the attempt to get it in the controller `test3()` method
   returns the value set in the file. However, in the `application.properties` where it is shown (falsely) as not resolved.

Use the `http-request.http` file to test the controller endpoints.