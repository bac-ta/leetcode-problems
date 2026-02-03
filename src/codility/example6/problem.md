You are given an undirected graph consisting of N vertices, numbered from 1 to N, and M edges.

The graph is described by two arrays, A and B, both of length M. Pair (A[K], B[K]), for K from 0 to M−1,
describes an edge between vertex A[K] and vertex B[K].

Your task is to check whether the graph contains a path from vertex 1 to vertex N going through all of the vertices,
one by one, in increasing order of their numbers. All connections on the path should be direct.

Write a function:

class Solution { public boolean solution(int N, int[] A, int[] B); }


that, given an integer N and two arrays A and B of M integers each, 
returns true if there exists a path from vertex 1 to N going through all vertices, one by one, in increasing order, or false otherwise.

Examples:

Given N = 4, A = [1, 2, 4, 4, 3] and B = [2, 3, 1, 3, 1], the function should return true.
There is a path (1 → 2 → 3 → 4) using edges (1, 2), (2, 3) and (4, 3).

Given N = 4, A = [1, 2, 1, 3] and B = [2, 4, 3, 4], the function should return false.
There is no path (1 → 2 → 3 → 4), as there is no direct connection from vertex 2 to vertex 3.