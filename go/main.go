package main

import (
    "encoding/json"
    "math/rand"
    "net/http"
    "time"
)

var quotes = []string{
    "Weeks of coding can save you hours of planning.",
    "It's not a bug – it's an undocumented feature.",
    "First, solve the problem. Then, write the code.",
    "There are two hard things in Computer Science: cache invalidation, naming things, and off-by-one errors.",
    "Software is like entropy: It is difficult to grasp, weighs nothing, and obeys the Second Law of Thermodynamics.",
}

func main() {
    rand.Seed(time.Now().UnixNano())

    http.HandleFunc("/quote", func(w http.ResponseWriter, r *http.Request) {
        q := quotes[rand.Intn(len(quotes))]
        json.NewEncoder(w).Encode(map[string]string{"quote": q})
    })

    http.ListenAndServe(":8080", nil)
}
