;;
;; Demonstrate calling Fortran from Clojure.
;;

(ns hw
   (:import (java.foreign Scope NativeTypes memory.Array memory.Pointer)
            (org.hello helloworld_lib)))

(defn -main [& args]
  (helloworld_lib/helloworld)
  (let [sc (helloworld_lib/scope)
        x (.allocateArray sc NativeTypes/DOUBLE (double-array [1 2 3]))
	s (.allocate sc NativeTypes/DOUBLE)]
	(helloworld_lib/fsum s 3 (.elementPointer x))
	(println (.get s))
    ))
