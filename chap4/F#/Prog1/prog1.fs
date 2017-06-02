(*
   CS 3490 F# Program #1
   Collection of simple F# functions
*)

module Fenwickjb

(*********************************************** C O D E **************)

// put all your code in this module
 module Code =
     // length of a list   
     let rec len L =
         if (List.isEmpty L)
         then 0
         else 1 + (len (List.tail L))

     // check if a number is positive
     let isPos num = num > 0

     // exercise 4.2 - extract age from 3-tuple (FName,LName,Age)
     let getAge (x, y, z) = z


     // exercise 4.5 - delete first occurence of an item in a list
     let rec delFirst item lst =
       match lst with
       | [] -> []
       | hd::tl -> if hd = item then tl
                   else hd :: delFirst item tl


     // delete all occurences of an item in a list
     let rec delAll item lst =
       match lst with
       | [] -> []
       | hd::tl -> if hd = item then delAll item tl
                   else hd :: delAll item tl


     // exercise 4.6 - improving textbook's quicksort
     let rec quicksort lst =
       match lst with
         | [] -> []
         | pivot::tail ->
           (quicksort (List.filter (fun n -> n < pivot) tail))
           @ [pivot]
           @ (quicksort (List.filter (fun n -> n > pivot) tail))


     // exercise 4.8 - unzip a list of tuples into a tuple of lists
     // If its an empty list then return the empty list.
     // Remove all first type items in tuple and append them in their own list.
     // Then the second, third, and so on in their own list.

     let rec unzip lstTup = []


     // find the minimum in a list
     let rec min lst =
       match lst with
         | hd::tl -> if hd < (min tl) then hd
                     else min tl


(*********************************************** T E S T S ************)

// put your unit tests in this module
 module Test =
     open Code        
     let lenTest () =
         printf "len [] ... "
         if (len []) = 0
         then printfn "passed."
         else printfn "FAILED."
     
         printf "len [1..8] ... "
         if (len [1..8]) = 8
         then printfn "passed."
         else printfn "FAILED."

     let isPosTest () =
         printf "isPos -3 ... "
         if (isPos -3) = false
         then printfn "passed."
         else printfn "FAILED."

         printf "isPos 0 ... "
         if (isPos 0) = false
         then printfn "passed."
         else printfn "FAILED."

         printf "isPos 3 ... "
         if (isPos 3) = true
         then printfn "passed."
         else printfn "FAILED."

     let getAgeTest () =
         printf "getAge tup ... "
         if (getAge ("T", "K", 22)) = 22
         then printf "passed."
         else printf "FAILED."

     let testAll () =
         lenTest ()
         isPosTest ()

 (**************************************************** M A I N **********)

 printfn "Welcome! Preparing to test..."        
 Test.testAll ()
 printfn "All testing is complete. Goodbye."
         
  
       
