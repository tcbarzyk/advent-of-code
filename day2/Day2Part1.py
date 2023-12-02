import re
with open("day2/day2-input2.txt", "r") as f:
    lines = f.readlines(); id = 0; sum = 0
    for line in lines:
        id += 1; possible = True
        sets = line[line.index(":")+1::].split(";")
        for set in sets:
            subsets = set.split(",")
            for subset in subsets:
                num = int(re.sub("[\\D]", "", subset))
                if "red" in subset and num > 12: possible = False
                elif "green" in subset and num > 13: possible = False
                elif "blue" in subset and num > 14: possible = False
        if possible: sum += id
print(sum)