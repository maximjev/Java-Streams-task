**Welcome!**

Hello! Welcome to this excersise! Your task is to perform a basic operations on nested object structures using Java built-in streaming API. You should implement 3 functions insid `Task.java`. All these operations come from real-life operations which are done in the production code. 

The rules are following: 
- You must not modify test classes
- You can (and should) modify (almost) all other classes in `src`
- You can click `Check` at any point of time to validate if your solution is correct

---

**THE TASK**

You will work with the following (very realistic) objects structure

```text
Results
  |_List<Offer>
           |__List<Sector>
                     |__List<Segment>
```
As you probably know form the air domain `Offer` can have 1 sector (if it is One Way offer) or 2 sectors (if it is Round Trip offer). Sector can have 1 or more Segments. Sector which represents a direct flight will have 1 segment. Sector with 1 stop will have 2 segments etc. 

You have to write 3 functions which will process the `Results`. We assume that they will be consistent i.e. if we deal with "Round trip" results - all Offers have 2 sectors. In addition all the fields will be filled and there won't be any tricky nulls so you don't need to protect code against them.

<div class="hint">
  Keep in mind that <code>Results</code> with empty list of Offers is a perfectly consitent and valid case ;)  
</div>

---

***Intro***

In the initial source code `Offer`, `Results`, `Sector` and `Segment` are all immutable objects. Each of them has a set of `final` fields and a constructor. However there is no way to access these fields (you may notice IDE warnings saying just that). During the assignment you need to make sure these objects have accessors methods or any other useful methods which `Value Objects` like them should have :) 

<div class="hint">
  Please notice that <code>Lombok</code> library is already on the classpath ;) 
</div>

---

***Task 1***

First function to implement is 
```java
Offer getShortestOffer(Results results){}
```
 The task here is to find an `Offer` which has shortest total duration. Total duration is a sum of the offer's `Sectors` duration. If two `Offers` have equal duration you can return any of them. 

<div class="hint">
  <code>.reduce()</code> from Java streams might be quite useful here.
</div>

*This task can be implemented in 1 line of code*

---

***Task 2***

You have to implement 
```java
List<Segment> getListOfDistinctSegments(Results results){}
```
This means you have to extract all the sectors from all the offers and all the segments from all the sectors and make a one list out of them making sure that it has distinct elements.

<div class="hint">
  <code>.flatMap()</code> function will be very very useful here
</div>

<div class="hint">
  This task might be hard if you forget about the role of <code>equals</code> function
</div>

*The task can be implementd in 1 line of code*

---

***Task 3***

A bit more complicated one. You need to implement: 
```java
List<List<Sector>> getDistinctSectorsGroupedByIndex(Results results) {}
```

It means that you need to return a list which will have number of elements equal to number of sectors in a single Offer. First element will be for the Outbound sectors, second for the Inbound sectors.
 In case of RoundTrip results we should get a list of 2 elements. In case of OneWay results a list with 1 element. 
 
 Each element is another list with unique Sectors which belong to either Outbound or Inbound. For example - if I search for a round trip flight AMS-LHR first list will contain various sectors for route AMS-LHR and second list various sectors of return flights on route LHR-AMS

<div class="hint">
  You can try to avoid <code>for</code> loops by using <code>IntStream.range()</code> and its method <code>mapToObj()</code>
</div>

*This time you might need more than 1 line of code ;) *