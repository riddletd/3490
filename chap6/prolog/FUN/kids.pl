%
% Kid-Animal friends
%
% Kids: Doug, Sue, Melanie, Ulysses
% Animals: Unicorn, Seahorse, Manatee, Dragon
%
% 1. No child has a pet that starts with same letter as their name.
% 2. Doug doesn't have a pet that lives in water.
% 3. Melanie is allergic to smoke.
% 4. Sue loves to fly.
%


% Facts to encode water pets, and smoky pets, and flying pets.

waterpets([seahorse, manatee]).
smokypets([dragon]).
flyingpets([unicorn, dragon]).

% Facts to encode pets start with letters D, S, M, U

d_pets([dragon]).
s_pets([seahorse]).
m_pets([manatee]).
u_pets([unicorn]).

kids :-
	    /* fact generators */
            waterpets(WP), smokypets(SP), flyingpets(FP),
	    d_pets(DPets), s_pets(SPets), m_pets(MPets), u_pets(UPets),

% Final solution generator: list of 4 kafriend entities

            Final = [kafriend(_,dragon),  kafriend(_,seahorse),
	    	     kafriend(_,manatee), kafriend(_,unicorn)],

	    /* constraints */
% 1. No child has a pet that starts with same letter as their name.
   /* 1 */  member(kafriend(doug,D), Final),   \+(member(D,DPets)),
            member(kafriend(sue,S),Final),     \+member(S, SPets),
            member(kafriend(melanie,M),Final), \+member(M, MPets),
            member(kafriend(ulysses,U),Final), \+member(U, UPets),

% 2. Doug doesn't have a pet that lives in water.
    /* 2 */  \+(member(D,WP)),

% 3. Melanie is allergic to smoke.
   /* 3 */  \+(member(M,SP)),

% 4. Sue loves to fly.
   /* 4 */  member(S,FP),


      	    /* pretty printer of D, S, M, U "solutions" */
	    prettyprinter(D,S,M,U),
	    nl.


prettyprinter(D,S,M,U) :-
	    write('Doug took home the '), write(D), nl,
	    write('Sue took home the '), write(S), nl,
	    write('Melanie took home the '), write(M), nl,
	    write('Ulysses took home the '), write(U), nl.

              

	
