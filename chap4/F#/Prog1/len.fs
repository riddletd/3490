
// comment

(* multi-line
   coment
   *)

let rec len L =
  if L = [] then 0
  else 1 + len (List.tail L);;

printfn "len of 5 element list is %d" (len [1..5]);;
