# command-group-revamp-tests

The tests need to run manually.
For now, these tests run the commands but do not check the end conditions (just because it was faster to check it manually with verbose output instead of simulating the desired flow).

In order to test control flow manually, change the verbosity in the tests. All command groups in this repo have a constructor that aceeps a "verbose" boolean, by default it is false. 

Things to test:

 - [x] basic tests - in `TestParallels.java` 
 - [x] jittery IsFinished tests - in `TestJitteryIsFinished.java` 
 - [ ] Cancelled in parallel tests 
 - [ ] Cancelled in command group tests 