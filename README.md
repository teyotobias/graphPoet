# graphPoet
Creates poetry from input text and "corpus" text primary using maps to construct a graph.

Example:

Poem corpus: 
To explore strange new worlds
To seek out new life and new civilizations

GraphPoet will use this corpus to generate a word affinity graph where vertices are case-insensitive words and edge weights are in-order adjacency counts.

Poem input: Seek to explore new and exciting synergies

The poet will use the graph to generate a poem by inserting (where possible) a bridge word between each pair
of input words given the poem input.

Resulting output: Seek to explore strange new life and exciting synergies
