///////////////////////////////////////////////////////////////////////////////////////////

Project 1 Submission by 
	Sree Pardha Saradhi Gunnam (UFID : 70304545)
	Nitin Agrahara Ravikumar (UFID : 73714398)

///////////////////////////////////////////////////////////////////////////////////////////

*--------------------------*
|                          |
|Project name : project1   |
|class name   : project1   |
|                          |
*--------------------------*

All cases mentioned below are done on CISE machine with have 2 cores.
                                                             _______

sample execution technique :
	
	scala project1 1000000000 24

where the first number is the range and the second is the number of elements whose squares have to be counted

Ask asked in the project the result

	time scala project1 1000000 4
	Start : 1347590964698
	
	real    0m2.627s
	user    0m4.656s
	sys     0m0.108s

CPU Usage = 1.8134
-------------------
 
	time scala project1 1000000000 2

	real    0m26.978s
	user    0m53.235s
	sys     0m0.148s

CPU Core Usage = 1.978
----------------------


Observation is that for lower ranges, a small work load does not lead to good parallelization. As the work load of each actor is increased, the CPU core increases. Althought for a larger input range, this variation isn't observed. CPU core utlizations is observed to be high i.e > 1.9 and 2 for very large loads. 

All cases mentioned below are run on our own laptops Ubuntu 4 core
                                                            ______
tinn@ubuntu:~/Desktop$ time scala project1 1000000 4
Start : 1347634115617

real	0m1.143s
user	0m3.040s
sys	0m0.152s

CPU Core Usage = 2.8
--------------------

We observed that on a 4 core machine, the the lesser the work load, the lesser the core usage.
For example ,

tinn@ubuntu:~/Desktop$ time scala project1 1000000000 4
Start : 1347634130408

real	0m29.256s
user	1m54.707s
sys	0m0.508s

CPU Core Usage = 3.9381
-----------------------

and

tinn@ubuntu:~/Desktop$ time scala project1 1000000000 1000
Start : 1347634806118

real	5m11.517s
user	20m34.921s
sys	0m1.328s

CPU Core Usage = 3.968
----------------------



Also, tests for really large numbers :
 time scala project1 1000000000 1000
Start : 1347653065174
244181759
391058002
667371211


real    8m11.065s
user    16m19.709s
sys     0m0.364s


