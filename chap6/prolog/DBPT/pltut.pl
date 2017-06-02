% This file is known as the knowledge base or just database.
% Type gprolog to load gprolog
% [fileName]. or consult('fileName.pl'). -  to load the knowledge base.
% halt. or C-d -  to exit gprolog.
% listing. - Shows you a lot of information about your knowledge base.
  % You should try to use this often to know what predicates are in your knowledge base.
% Predicates - Most of the commands in prolog.


% Output method
% write('Hello world.'), nl, write('Lets Program!').
  % nl - newline
  % tab(#) - tab a # of whitespaces
% format('options ~w ~s ~n', [Variables, "String"]) - 
  % options
    % ~w - variable
    % ~s - string
    % ~n - newline
    % ~#f - A float with a certain # of digits after the radix.


% Facts, Predicates, & Atoms
loves(romeo, juliet).
loves(trevor, kari).
% Fact - loves(romeo, juliet). - This can be read as "romeo loves juliet"
% Predicate - loves
% Atoms - romeo & juliet
% Atoms are constants and arguments for a predicate.



% Rules - Use :- to define one.
% ":-" can be read as "if"
loves(juliet, romeo) :- loves(romeo, juliet).
% Clauses - are facts and rules


% Variable - Objects that we cannot name at run-time.
% Variables start with an uppercase letter and are used to answer questions.


% Stuff to know about Prolog:
% Keep all 'same' predicate definitions together.
% Commas (,) - represent &&

% Rule Example
happy(albert). % This can be read as "albert is happy"
happy(trevor).
happy(kari).
happy(broderick).
with_trevor(kari).
near_water(trevor).

runs(trevor) :-
 happy(trevor).

dances(kari) :-
 happy(kari), with_trevor(kari).

does_kari_dance :- dances(kari),
 write('Kari will dance if she is happy and with Trevor.').

swims(trevor) :- happy(trevor), near_water(trevor).



%%% Variables %%%

male(trevor).
male(broderick).
male(alec).
male(sam).
male(chris).

female(kari).
female(olivia).
female(kelly).
female(christa).
female(callie).

parent(chuck, trevor).
parent(angela, trevor).
parent(marieta, kari).
parent(marieta, landon).
parent(donald, landon).
parent(peggy, marieta).
parent(nancy, chuck).
parent(tilmon, chuck).
parent(james, marieta).
parent(barbara, angela).
parent(greg, angela).



%%% Axioms & Derived Facts %%%

grandparent(Grandparent, Grandchild) :-
  parent(Parent, Grandchild),
  parent(Grandparent, Parent).

get_grandrelation(X, Y) :-
  grandparent(X, Y),
  format('~w ~s ~w ~n', [X, "is the grandparent of", Y]).

stabs(tybalt, romeo, sword).
hates(romeo, X) :- stabs(X, romeo, sword).


%%% is operator %%%
what_grade(5) :-
  write('Go to kindergarten').

what_grade(Other) :-
  Grade is Other - 5,
  format('You are in grade ~w', [Grade]).



%%% Complex Terms & Structures %%%

% Structure - An object made up of multiple objects or components.
% Arity - The # of parameters

has(albert, olive).
owns(albert, pet(cat, olive)).

customer(trevor, riddle, 124.65).
customer(kari, johnson, 30.43).

get_cust_bal :-
  customer(Fname, Lname, Bal),
  format('~w ~w owes us $~2f', [Fname, Lname, Bal]).


% Check to see if 2 lines are vertical or horizontal
vertical(line(point(X, Y), point(X, Y2))).
horizontal(line(point(X, Y), point(X2, Y))).


%%% Operators %%%

% <
% >
% >=
% =<
% \+
% =









