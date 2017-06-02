module apr24
       let rec removeOdds lst =
       	   match lst with
	   | [] -> []
	   | hd :: tl -> if head % 2 = 1
	                 then removeOdds tl
			 else hd :: (removeOdds tl);;
