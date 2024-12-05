
#### Streams
Streams are exactly that, unbounded and infinite. Similar to a log of key, value pairs. This happened then this happened, then this happened ... 

![](Pasted%20image%2020241006101847.png)

#### Tables

Tables are somewhat similar to database tables using key as the primary key, where you do all upserts and deletes.

![](Pasted%20image%2020241006102149.png)

When to use what:

![](Pasted%20image%2020241006102317.png)


Streams and tables are linked in the sense that a stream is a changelog of a table and table is a snapshot of a stream.
The changelog can recreate the table, and the recreated tables output stream is a new changelog. This cycle can continue forever.
![](Pasted%20image%2020241006103442.png)


