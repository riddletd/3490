
cocacolaSoda(cocacola).
cocacolaSoda(cocacola_zero).
cocacolaSoda(cocacola_life).
cocacolaSoda(cocacola_light).
cocacolaSoda(diet_coke).
cocacolaSoda(sprite).
cocacolaSoda(fanta).
cocacolaSoda(fresca).
cocacolaSoda(mello_yello).

cocacolaWater(dasani).
cocacolaWater(ciel).
cocacolaWater(smartwater).

cocacolaEnergy(powerade).
cocacolaEnergy(powerade_zero).
cocacolaEnergy(glaceau_vitaminwater).

cocacolaJuice(simply_orange).
cocacolaJuice(minute_made).
cocacolaJuice(odwalla).

cocacolaTea(fuze).
cocacolaTea(honest_tea).


pepsiSoda(amp_energy).
pepsiSoda(fayrouz).
pepsiSoda(dukes).
pepsiSoda(mirinda).
pepsiSoda(mountain_dew).
pepsiSoda(caffeine_free_mountain_dew).
pepsiSoda(diet_mountain_dew).
pepsiSoda(kickstart).
pepsiSoda(mountain_dew_baja_blast).
pepsiSoda(mountain_dew_code_red).
pepsiSoda(mountain_dew_live_wire).
pepsiSoda(mdx).
pepsiSoda(mountain_dew_sangrita).
pepsiSoda(mountain_dew_voltage).
pepsiSoda(mountain_dew_white_out).
pepsiSoda(mug_root_beer).
pepsiSoda(pepsi).
pepsiSoda(diet_pepsi).
pepsiSoda(pepsi_cola).
pepsiSoda(pepsi_jazz_strawberries_and_cream).
pepsiSoda(pepsi_jazz_black_cherry_and_vanilla).
pepsiSoda(pepsi_lime).
pepsiSoda(pepsi_max).
pepsiSoda(pepsi_perfect).
pepsiSoda(crystal_pepsi).
pepsiSoda(mist_twist).

soda(X) :- pepsiSoda(X).
soda(X) :- cocacolaSoda(X).
water(X) :- cocacolaWater(X).
							      
