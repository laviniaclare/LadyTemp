from scipy.interpolate import interp1d
import numpy as np
import matplotlib.pyplot as plt

x = np.array ([0, 6, 9, 8.414, 11, 15, 20.604, 30.546])
y = np.array ([[97.986, 97.903, 97.450, 97.205, 98.184, 98.465, 98.352, 97.996]])

f = interp1d(x, y, kind='linear')

month_of_data = f(range(0, 30))[0]

counter = 0
list_pairs = []
for x in month_of_data:
	list_pairs.append([counter, x]) 
	counter += 1
print list_pairs




