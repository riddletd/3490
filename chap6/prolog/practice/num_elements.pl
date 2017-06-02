
% Find the numebr of elements in the list.

num_elements([], 0).
num_elements([_|Tail], Result) :- num_elements(Tail, R), Result is R + 1.
