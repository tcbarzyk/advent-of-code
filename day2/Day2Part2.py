import re
with open("day2/day2-input2.txt", "r") as f:
    lines = f.readlines(); sum = 0
    for line in lines:
        minRed = 0; minGreen = 0; minBlue = 0
        sets = line[line.index(":")+1::].split(";")
        for set in sets:
            subsets = set.split(",")
            for subset in subsets:
                num = int(re.sub("[\\D]", "", subset))
                if "red" in subset and num > minRed: minRed = num
                elif "green" in subset and num > minGreen: minGreen = num
                elif "blue" in subset and num > minBlue: minBlue = num
        sum += minRed * minGreen * minBlue
print(sum)