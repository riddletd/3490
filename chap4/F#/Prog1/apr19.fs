(*
   Talked about Lists, Tuples, Unit, Option types.

   Talked about list ranges: [1..10] and [1..2..10]
   Talked about list generators.

   Played with recursive list functions:
   len (length)
   mem (member of)
   *)

module April19
  let rec len L =
      if (List.isEmpty L) then 0
      else 1 + (len (List.tail L))

  let rec mem item L =
      if (List.isEmpty L) then false
      else if (List.head L) = item then true
      else 1 + (mem item (List.tail L))


  
       
