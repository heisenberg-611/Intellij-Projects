#include <iostream>
#include <vector>
#include <algorithm> 
#include <iterator>  
#include <utility>   


template<typename Iterator>
void bubble_arrange(Iterator begin, Iterator end) {
  
    int n = std::distance(begin, end);
    if (n < 2) return;

    for (int i = 0; i < n; ++i) {
        bool swapped = false;
    
        Iterator it = begin;
        for (int j = 0; j < n - 1 - i; ++j) {
    
            Iterator current = it;
            Iterator next = it;
            ++next; 
            
            if (*current > *next) {
                std::swap(*current, *next);
                swapped = true;
            }
            ++it;
        }
  
        if (!swapped) {
            break;
        }
    }
}


int main() {

    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n;
    std::cin >> n;


    if (n == 1) {
        int temp;
        std::cin >> temp;
        std::cout << "YES\n0\n";
        return 0;
    }
    if (n == 2) {
        int temp1, temp2;
        std::cin >> temp1 >> temp2;
        std::cout << "YES\n0\n";
        return 0;
    }


    std::vector<int> a(n + 1);
    std::vector<int> target_s(n + 1); 
    for (int i = 1; i <= n; ++i) {
        std::cin >> a[i];
        target_s[i] = a[i];
    }


    bubble_arrange(target_s.begin() + 1, target_s.end());

    std::vector<int> a_odd, a_even, s_odd, s_even;
    for (int i = 1; i <= n; ++i) {
        if (i % 2 == 1) { 
            a_odd.push_back(a[i]);
            s_odd.push_back(target_s[i]);
        } else { 
            a_even.push_back(a[i]);
            s_even.push_back(target_s[i]);
        }
    }

    bubble_arrange(a_odd.begin(), a_odd.end());
    bubble_arrange(s_odd.begin(), s_odd.end());
    bubble_arrange(a_even.begin(), a_even.end());
    bubble_arrange(s_even.begin(), s_even.end());


    if (a_odd != s_odd || a_even != s_even) {
        std::cout << "NO\n";
        return 0;
    }


    std::cout << "YES\n";
    std::vector<std::pair<int, int>> operations;


    std::vector<int> odd_indices, even_indices;
    for (int i = 1; i <= n; ++i) {
        if (i % 2 == 1) odd_indices.push_back(i);
        else even_indices.push_back(i);
    }

    int n_odd = odd_indices.size();
    for (int i = 0; i < n_odd; ++i) {
        for (int j = 0; j < n_odd - 1 - i; ++j) {
            int idx1 = odd_indices[j];
            int idx2 = odd_indices[j + 1];
            
            if (a[idx1] > a[idx2]) {

                std::swap(a[idx1], a[idx2]);
                operations.push_back({idx1, idx2});
            }
        }
    }

   
    int n_even = even_indices.size();
    for (int i = 0; i < n_even; ++i) {
        for (int j = 0; j < n_even - 1 - i; ++j) {
            int idx1 = even_indices[j];
            int idx2 = even_indices[j + 1];
            
            if (a[idx1] > a[idx2]) {
                std::swap(a[idx1], a[idx2]);
                operations.push_back({idx1, idx2});
            }
        }
    }


    std::cout << operations.size() << "\n";
    for (size_t i = 0; i < operations.size(); ++i) {

        std::cout << operations[i].first << " " << operations[i].second << "\n";
    }

    return 0;
}