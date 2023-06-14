#include <iostream>
#include <vector>
#include <fstream>
using namespace std;

ifstream fin("date.in");
ofstream fout("date.out");
//pastreaza nodurile adiacente
vector<vector<int>> next_nodes(100000);

//DFS
bool traverse(vector<bool> visited, int node) {
    if (visited[node]) {
        return true;
    }

    visited[node] = true;
    for (int v : next_nodes[node]) {
        if (traverse(visited, v)) {
            return true;
        }
    }

    visited[node] = false;
    return false;
}

int main() {
    int n, m;
    int first, second;
    fin >> n >> m;

    //insereaza nodurile adiacente in map
    for (int i = 1; i <= m; i++) {
        fin >> first >> second;
        next_nodes[first].push_back(second);
    }

    bool has_cycle = false;
    vector<bool> visited(n + 1, false);
    //DFS pe fiecare nod
    for (int i = 1; i <= n; i++) {
        if (traverse(visited, i)) {
            has_cycle = true;
            break;
        }
    }

    fout << has_cycle;
}