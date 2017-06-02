
List =
[
        Kari,
	Trevor,
	Broderick,
	Alec,
	Reece,
	Matt,
	Chris,
	Sam,
	Charlie,
	Nathan,
	Alex,
	Brenner,
	Chad,
	Josh,
	Andy
].

% Code to find the last item in the list.
last([H|T], LastItem) :- last(T, LastItem).
last([X], X).

% Split function
split([R,L|T], [R|T1], [L|T2]) :- split(T, T1, T2), split([],[],[]), split([K], [K], []).
