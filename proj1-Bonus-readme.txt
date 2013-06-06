///////////////////////////////////////////////////////////////////////////////////////////

Project 1 Submission by 
	Sree Pardha Saradhi Gunnam (UFID : 70304545)
	Nitin Agrahara Ravikumar (UFID : 73714398)

///////////////////////////////////////////////////////////////////////////////////////////

*----------------------------------------*
|                                        |
|Project name      : project1 Bonus      |
|Source class name : remotesource_main   |
|Sink Class name   : BasicSinkApp2       |
|                                        |
*----------------------------------------*
Only two files are needed. One on the main machine and the client code is same over alll other machine. We do not have separate files for separate machines.

We have successfully impleted the bonus question and have tested the usage over 10 machines (lin116-00-09). We have used the same logic that we had in the mainquestion with the addition of a few values and check parameters.

All remote machine look up their machine name and register themselves accordingly. The main boss establishes connection to all these and splits the workload to suit.

The program can run on any number of machines (<11)

We have coded it in such a way that no actor in any machine sits idle.
In case a actors send back the result, if the main baoss hasn't received result from another actor, the boss will delegate that work again to the free actor. Once the main boss receives all results, exit is called on all actors and the main program terminates.

Try catch blocks have been added at multiple location to ensure safe execution.

We are employing the port range from 
1720 - 1729

We have noticed that the solution for a given problem executes much fater on a distributed system.

For example :

SINGLE :
nar@lin116-12:~/Desktop$ time scala project1 100000000 20
Start : 1347656952817
62780852

real    0m5.430s
user    0m10.217s
sys     0m0.144s

MULTIPLE

sgunnam@lin116-00:~/dos$ time scala remotesource_main 100000000 20
Start : 1347659887579
62780852 : 78828731413644310 : 2.80764548E8

real    0m2.680s
user    0m4.784s
sys     0m0.100s

faster by a factor of 2.1 for the given input


Note : We also observed that while(true) and receive and loop react do not provide a substantial differenc for the ranges we tried. Although, we did notice that our multiple machine code faced problems when we emplyed Loop receive.