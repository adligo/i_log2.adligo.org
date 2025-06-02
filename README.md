# i_log2.adligo.org
This is the next generation of the Adligo I_Log stuff, based on interface mixins.

This optimal logging API prevents the creation of Strings when the logger is set to a higher level than the log statement.  This is accomplished through multiple paths;

#### The Imperative Style Path

This is the classic way to ensure your string "hey you guys" isn't created unless the log is set to Debug or lower.

```
   I_Log log = YourLogFactory.get("example.com");
   if (log.isDebugEnabled()) {
      log.debug("hey you guys");
   }
```

#### The Functional Style Path

This also prevents the creation of strings (i.e. "number 5 is alive") unless the log is set to Debug or lower.  For details about how this works see;
[BytecodeTest Comments in](https://github.com/adligo/i_log2_tests.adligo.org/blob/main/src/i_log2/adligo/org/shared/BytecodeTest.java)

```
   I_Log log = YourLogFactory.get("example.com");
   log.ifDebug(() -> "number 5 is alive");
```

#### The Functional Style Path with Succinct Method Names 

Since logging is ubiquitous we have also provided shortened method names as follows; 

```
   I_Log log = YourLogFactory.get("example.com");
   log.ifT(() -> "trace number 5");
   log.ifD(() -> "debug number 5");
   log.ifI(() -> "info about number 5");
   log.ifW(() -> "warn number 5");
   log.ifE(() -> "number 5 has errors");
```