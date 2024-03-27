# pc-builder-store

## Design Decisions:

### Classes:

The PC class has been designed using composition as it is composed of a PCTower, HDD and a PCScreen. The HDD was made into an entity so as to be able to contain its units and print its description using all of its attributes, however this is not for it to be sold separately. While it can be said that Workstation is composed of a PC and an Operating System, it can also be perceived as an is-a relationship rather than a has-a relationship. Workstation is a PC, but a PC is not a workstation, so inheritance is used here instead of composition as it is an opportunity to showcase it for the assignment. Attributes of each class are kept private for encapsulation and while it would have been more efficient to have custom toString() functions for each class, lists of String are returned instead to decouple the backend from the frontend. Instead, printing to the console is handled by the UI class that retrieves the string lists and displays them in the appropriate manner. This is also more scalable in the case that a GUI is implemented in the future.

### UI:

Research was made into java's version of Qt5 with which I have experience with, however JFrame and other libraries seemed out of scope. To maintain focus on portraying OOP through component design, a console UI is used.
