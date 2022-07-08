Stage 1 - test:

1. Ability to add new library users. Users are divided into two types:
• Student - can borrow a maximum of 4 books or magazines the next
• Lecture - can borrow up to 10 books or magazines at the same time
Each user must have a full name and number in the library. There may be two
users with the same name and surname but the card number in the library must be unique.
Card number generated automatically as a result of adding a user to the library - no
has its importance.
2. Possibility to sign out all library users. Each line is for a different user
First of all, I provide the name, card number in the library and type (separated
semicolons). The type can be student or L when user is
lecturer
e.g.
Piotr; Kowalczyk; 13; S
Maria; Nowak; 11; S

Stage 2 - test:
1. Ability to add to the collection in two materials:
• Book - each must have a title and author
• Warehouse - each must have a title and number of the magazine
If you get there is access / warehouse to spend how much amount all
a copy of this book / magazine. The method of adding Books and Magazines should be able to do so
adding one or several elements regardless of the type (book, magazine).
2. Possibility of lending Books and Magazines to the user, if there is one in the library
there is sufficient rental shop for rental and the user has the option to borrow
another copy.
3. Possibility to unsubscribe from the library at all Warehouses. Each poem is for one
number and number of places in the ranking, number, number of all places, and quantity
Location of instances (separated by semicolons)
e.g.
Traveler; 03/2017; 30; 17
National Geographic; 01/2016; 15; 13
4. Possibility to unsubscribe from all Books from the library. Each line is for one title
and I make available in order of place, author, places of availability and the amount of space for the place
instances (separated by semicolons)
e.g.
With fire and sword; H. Sienkiewicz; 20; 7
Bourne's identity; R. Ludlum; 40; 33
5. Ability to add book / magazine lists from a text file. Each line in the file
Be title, author / number, number of copies to be added and type (B - book, M - magazine)
separated by a semicolon. If there are already books in the library with a text file then we increase to
ICT equipment. Below is an example of the content of the book file:
With fire and sword; H. Sienkiewicz; 20; B
Bourne's identity; R. Ludlum; 10; B
Game of Thrones; George R.R. Martin; 15; B
National Geographic; 01/2016; 15; M
6. Ability to write to the new file system those users who have now
borrowed loans and the titles and the author of the books or the titles listed for each user i
the numbers of the warehouses we have. The institution has some of the same book-sharing services or
magazine to be equal to be several times
e.g.
ID5 [With Fire and Sword-H. Sienkiewicz; By fire and sword-H.
Sienkiewicz; Traveler-03/2017; National Geographic-01/2016]
ID24 [Traveler-03/2017; National Geographic-01/2016]
