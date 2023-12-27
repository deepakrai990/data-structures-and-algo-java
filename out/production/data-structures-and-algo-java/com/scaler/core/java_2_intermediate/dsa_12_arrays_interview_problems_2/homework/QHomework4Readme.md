### Q4. Ratio of Boys and Girls
#### Problem Description
```text
In a country where everyone wants a boy, each family continues 
having babies till they have a boy. After a long time, what is 
the proportion of boys to girls in the country? (Assuming 
probability of having a boy or a girl is the same) > Round off 
your answer to two decimal places and output the 
answer as I.xx where I is the integer part of your 
answer, and xx is the first two decimal places of 
the rounded-off answer.
```
#### Options
```text
1. Red
2. Blue
3. In deterministic
```
* Solution Approach
```text
Let G denote a girl and B denote a boy. Then the possible 
configuration of children are B, GB, GGB, GGGB, GGGGB and so on.

Expected Number of 
girls = 0*(Probability of B) + 1*(Probability of GB) + 2*(Probability of GGB) + …
```

* Complete Solution
```text
Let P be the probability that a child is girl and (1-P) be 
probability that a child is boy.

Since the probability of having a boy or a girl is the same, 
so both P and (1-P) is 1/2.

Let G denote a girl and B denote a boy. Then the possible 
configuration of children are B, GB, GGB, GGGB, GGGGB and so on.

Let N be the expected no. of girls before a boy is born

    N = 0*(Probability of B) + 1*(Probability of GB) + 2*(Probability of GGB) + ...
    
    N = 0*(1-P) + 1*P*(1-P) + 2*P*P*(1-P) + ...

    N = 0*(1/2) + 1*(1/2)2 + 2*(1/2)3 + ... 
    
    (1/2)*N = 0*(1/2)2 + 1*(1/2)3 + 2*(1/2)4 + ... (Dividing both sides by 1/2)

    Subtracting the above two equations,
    N - (1/2)*N = 1*(1/2)2 + 1*(1/2)3 + 1*(1/2)4 + ...
    
    (1/2)*N = (1/4)/(1 - 1/2) = 1/2 (using sum formula of infinite GP 
    with ratio less than 1)
    
    N = 1

So the expected number of number of girls = 1

Since the expected number of girls is 1 and there is always 
a baby boy, the expected ratio of boys and girls is 1:1

Thus the answer will be 1.00
```
