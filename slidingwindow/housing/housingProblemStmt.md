# Housing (Fixed sliding window of size K)

So the question is called housing and let us understand the problem statement.
It says there is a road and there is a sequence of vacant lots of land.
Each plot has a different area and the areas form a sequence of the areas one mile area from A1 to end, and you want to buy acres of land to build a house.
So on one side of road, there are some plots and each of these plots as a different area.
You want to build a house whose it is **exactly K units.**
And for that you can combine a section of the plot.
So maybe you want to build a house with eight acres.
You can combine these two plots to build your house.
Do you want to find all segments of continuous plots that you can use to build your house

Example: 1 3 2 1 4 1 3 2 1 1 2, K = 8 

Output: 
        2 5
        4 6
        5 4

