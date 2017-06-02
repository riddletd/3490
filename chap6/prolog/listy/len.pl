
len([_|Tail], Length) :- len(Tail, TailLen), Length is TailLen + 1.
len([], 0).
