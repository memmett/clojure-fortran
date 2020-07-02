# Calling Fortran from Clojure

Why would you not want to do this?

## Overview

We can call Fortran from Clojure using C as a bridge:
1. Make your Fortran routine C callable (`bind (c)`).  Make sure you follow all the best practises for doing this.
2. Make a C header file that prototypes your Fortran routines.
3. Use [Project Panama][1] to generate a Java interface.
4. Use the usual Clojure/Java interop to call the Java interface.

See the sample code in [clojure-fortran][2] as a guide.

To generate a shared object containing your Fortran routines:

```sh
gfortran -shared -o libhelloworld.so helloworld.f90
```

To generate the Java interface (after installing Panama):
```sh
jextract -t org.hello -L. -lhelloworld helloworld.h -o helloworld.jar
```

To run the Clojure demo:
```sh
export LD_LIBRARY_PATH=$PWD
clojure -m hw src/hw.clj
```

[1]: https://openjdk.java.net/projects/panama/
[2]: https://github.com/memmett/clojure-fortran

