# Virtual Pet Run Amok!

## What it is 
WCCI Fall Flex 2018 graded project

This is a console app that uses a game loop to simulate running a shelter for virtual pets, letting you tend to their needs which change with time.

The shelter for virtual pets gets more complicated with inheritance when robotic pets show up! 

Besides having regular pet needs like playing, the organic pets and the robotic pets have different needs. Organic pets have needs like hunger and thirst, and robotic ones need their batteries changed and joints oiled. The organic cats have a litterbox that needs to be cleaned, and the organic dogs are in individual cages. All the pets need to be played with to combat boredom and increase well-being.

## Things I did
- Let you add a pre-populated list of pets to the shelter, to save the user time when playing/evaluating.
- Stored the pets in four separate HashMaps. When the user admits a new pet the app checks that the pet's name isn't already in use in the shelter and prompts the user for a different name, if necessary, to prevent any problems.
- Each organic dog has its own Cage object that gets dirtier as a result of the dog's activity. Dogs that have been walked have a 0 chance of pooping in their cages until the next tick() resets the chance to 1.
- The pets' needs are evaluated and changed every three interactions using the tick() method.
- Gave the robotic pets a battery level that needs to be monitored. The battery charge depletes over time. Playing with the robotic pet also depletes the battery faster.
- Displayed the pets' status using a visual level meter instead of number like hunger: 38. This lets the user take in the shelter's status at a glance and tend to the most critical needs.

## What I'd like to add in the future
Events that are triggered only when some instance variables reach a trigger point. 
Like: when the robotic dogs reach some pooled level of boredom they start playing with each other and no longer wish to play with a human. When the robotic cats get too bored as a whole they escape the shelter and leave to further their goals of world domination. Make the pets run truly amok.