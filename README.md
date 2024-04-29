Assignment:
With the dimensional connections mapped out via our separate chaining hash table, we can use this to create a final Adjacency List in order to more efficiently navigate the Spider-Verse and track down anomalies. 

This Java class will take three command line arguments in the following order: a dimensions list input file name, a spiderverse input file name, and an output file name.
The dimensions input file will be formatted the same as above.
The spiderverse input file will be formatted as follows:
An integer d (the number of people in the file)
d lines, each with
The dimension this person is currently at (an integer)
The name of the person (a String)
The dimensional signature of the person (an integer)
With the clusters being completed, you and Miles need to represent these connections between each Dimension as an adjacency list showing undirected links.
Let the first Dimension in a cluster be linked to every Dimension in its cluster and have a link going back to represent it being undirected. More formally, in the adjacency list there must exist an edge from first→ d and d → first for each dimension appearing in a cluster starting at first.
So edges exist from d1 → d2 and d2 → d1, d1 → d3 and d3 → d1, ………….. , d1 → dn and dn → d1 (where dn is the last dimension in the cluster)
       2. Insert people from the Spiderverse input file into their corresponding dimensions. They belong to a dimension, they’re not connected via edges.

The output file will be formatted as follows:
a lines, where each line starts with a dimension number, then lists all the dimensions linked to that dimension (space separated)
The order in which you output the lines DOES NOT MATTER for grading. 


NOTES:
we are mainly looking at collider.java , clusterTable.java AdjacencyList.java and Spiderverse.java 

expected output

67 2099 
46 1024 94 6510 301 92 31 
92 8107 42 301 46 
831 31 
120 440 
120703 31 
210 1218 
6510 46 
831110 90214 
416 1024 
92810 42 
31 1024 65 22191 120703 199999 751263 831 111 431 46 301 
94 46 
616 440 
314 42 
2099 835 67 211 419 1218 65 404 50101 
419 2099 
1080 440 
26496 1024 
2024 440 
688 1024 
90214 831110 214 50101 404 8311 440 
1218 66 13122 161010 13810 210 65 1024 2099 404 
13810 1218 
111 31 
161010 1218 
829 301 
199999 31 
352 1024 
8107 96283 91 42 31913 92 301 
112 1024 
65 161 417 1024 31 1218 2099 
55 8311 
91 8107 
161 65 
211 2099 
61610 42 
22191 31 
1024 688 928 14512 26496 1920 112 336 352 416 31 46 65 1218 
431 31 
138 42 
96283 8107 
13122 1218 
1610 42 
1920 1024 
31913 440 8311 42 8107 
213 50101 
42 1610 138 61610 92810 314 31913 440 8107 92 
404 2099 1218 50101 90214 
1048 440 
8311 55 439 90214 50101 440 31913 
336 1024 
66 1218 
928 1024 
439 8311 
344 440 
50101 213 404 2099 90214 8311 
214 90214 
301 829 92 8107 46 31 
1992 440 
14512 1024 
835 2099 
751263 31 
417 65 
440 1992 1048 616 1080 2024 120 344 8311 90214 31913 42 

current output:
1920 1024 1024
26496 1024 1024
1024 688 688 928 928 14512 14512 26496 26496 1920 1920 112 112 336 336 352 352 416 416 31 31 46 46 65 65
138 42 42
831110 90214 90214
92810 42 42
751263 31 31
404 2099 2099 50101 50101
1048 440 440
96283 8107 8107
31 1024 1024 22191 22191 120703 120703 199999 199999 751263 751263 831 831 111 111 431 431
416 1024 1024
928 1024 1024
417 65 65
161 65 65
419 2099 2099
31913 440 440 42 42
61610 42 42
42 1610 1610 138 138 61610 61610 92810 92810 314 314 31913 31913 8107 8107
8107 96283 96283 91 91 42 42 92 92
301 829 829 92 92 46 46
46 1024 1024 94 94 6510 6510 301 301
431 31 31
22191 31 31
14512 1024 1024
688 1024 1024
2099 835 835 67 67 211 211 419 419 1218 1218 404 404
50101 213 213 404 404 90214 90214
439 8311 8311
55 8311 8311
1080 440 440
440 1992 1992 1048 1048 616 616 1080 1080 2024 2024 120 120 344 344 8311 8311 31913 31913
314 42 42
199999 31 31
829 301 301
831 31 31
65 161 161 417 417 1024 1024 1218 1218
13122 1218 1218
66 1218 1218
1218 66 66 13122 13122 161010 161010 13810 13810 210 210 65 65 2099 2099
67 2099 2099
835 2099 2099
1992 440 440
1610 42 42
336 1024 1024
210 1218 1218
211 2099 2099
213 50101 50101
214 90214 90214
344 440 440
91 8107 8107
92 8107 8107 301 301
94 46 46
352 1024 1024
90214 831110 831110 214 214 50101 50101 8311 8311
2024 440 440
616 440 440
6510 46 46
111 31 31
161010 1218 1218
112 1024 1024
13810 1218 1218
8311 55 55 439 439 90214 90214 440 440
120 440 440
120703 31 31


its adding numbers twice , i just need to get rid of this but dont know how
