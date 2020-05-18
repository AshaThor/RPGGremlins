#Databace
###Powered by PostgreSQL

####Data Design
The DB is one of the most complex yet vital parts of the application
For this reason we need to get it right, im looking into the use of 
reference tables and looking at existing datastructures similar to
the one im wanting to build after having a long chat with another dev 
deciding on tables and links, going from three to many, many tables and ideas

####The basic plan
The basic plan is to have 4 high level tables
* User
* Character
* Character_Campaign
* Campaign

This will deal with users assigned to characters and then characters assigned
to campaigns and will hopefully create a nice flow to this

#####Going Deeper
So the next level of the database is the fuster cluck of making a 
character, from stats and skills, to proficiencies and modifiers. 
This is where the database goes from 4 tables to 40.
 
 It's all in a notebook, so I will update this .md with the deep dive tomorrow
 also going to search if it has been done before by someone with alot
 more database knowledge than me