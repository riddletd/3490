(*
   Fri Apr 14 in-class "quiz"
   Write a simple increment function

   Sample use:
   > incr 5
   val it : int = 6
*)


// Acceptable for in-class quiz on Apr 14:

(*
module Apr14
  let incr value = value+1
*)


  // But this also requires loading into fsharpi and then
  // testing manually. Let's learn to write code that also
  // tests itself.


(*
module Apr14
  let incr value = value+1

  let incrtest = incr 5
*)

// The above didn't print anything via mono

(*
module Apr14
  let incr value = value+1

  let incrtest = incr 5
  printfn "%d" incrtest
*)

// That's using a "temp" value, let's just call function instead.

(*
module Apr14
  let incr value = value+1

  printfn "%d" (incr 5)
*)

// The above prints, but how do we know it worked?

(*
module Apr14
  let incr value = value+1

  printfn "(incr 5) returns %d" (incr 5)
*)
  
// Better, but tester still has to "figure out" if that passes


(*
module Apr14
  let incr value = value+1

  printf "Testing incr...."
  if 6 = (incr 5) then 
      printfn "passed." 
  else printfn "FAILED."
*)
  
// The above helps tester know much better!
// But as we get more proficient with F# we will have more
// code and more tests. Our programs will get bigger and
// bigger. So how can we manage it better? Methods/modules...

module Apr14
  module Code = 
    let incr value = value+1

  module Test = 
    let incrTest () = 
      printf "Testing incr...."
      if 6 = (Code.incr 5) then 
          printfn "passed." 
      else printfn "FAILED."
  
  Test.incrTest ()
(*
*)




