### Modular Inverse
* Modular division is a bit more complex than modular addition, subtraction, and multiplication. Division in modular arithmetic requires the use of the modular inverse, which is an integer <span>`x`<sup>`-1`</sup></span> such that `(`<span>`x` `*` `x`<sup>`-1`</sup></span>) `mod m = 1`. Not every number has a modular inverse, but when it exists, it allows us to define modular division.


* To compute the modular inverse of `a` modulo `m`, we need to find an integer `x` such that `(a * x) mod m = 1`. This can be done using the Extended Euclidean Algorithm.