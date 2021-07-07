# GarbageCollectionSystem

Description : It is a customized implementation of internal working of Garbage collector. 

Key Points -
1. How many ways we can make an object eligible for Garbage colelction - By Nullyfying the reference, Can assign the object to any other reference variable, Object created inside method, by creating anonymous object. In our implementation we are calling the Garbage collector for the object created inside method.
2. How to make sure the objects that have been created are alive or dead ? - Every object when created will be added in a set by default by calling a custom method getReference(Object) on that particular object. Even if, in code we have called this method again on the same object. The reference will not be added because first it checks in the hashMap for the Hashcode if it exists or not.
3. Compaction - When the garbage has been removed from the heap, the Garbage Collector can consider compacting the resulting set of objects to remove the spaces that are between them. The process of compaction is complicated because, if any object is moved, the GC must change all the references that exist to it. It's not implemented.
4. Algo used - Mark and Sweep alog is used in this implementation.
Mark : It states that Everytime there is a process of clean up , it starts from root node and checks that if the hashcode of object for which clean up is required exist in set of all references or not. if it exists then that object hashcode will be marked to delete by adding into a new set of deletereference.
Sweep : It is the process to reclaim the memory by deleting the objects that are lying in deletereferences set.
