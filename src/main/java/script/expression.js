function merge(a, b) {
    c = a * b;
    return c;
}

function isPrime(num) {

    if (num <= 1) {
        print("Please enter a positive integer >= 2.")
        return false
    }

    var prime = true
    var sqrRoot = Math.round(Math.sqrt(num))

    for (var n = 2; prime & n <= sqrRoot; ++n) {
        prime = (num % n != 0)
    }

    return prime
}
