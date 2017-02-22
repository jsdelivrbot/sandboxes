# NumPy is often used to load, manipulate and preprocess data
import numpy as np

from tensorflow.contrib import learn
from tensorflow.contrib import layers

features = [layers.real_valued_column("x", dimension=1)]

estimator = learn.LinearRegressor(feature_columns=features)

x = np.array([1., 2., 3., 4.])
y = np.array([0., -1., -2., -3.])
input_fn = learn.io.numpy_input_fn({"x": x}, y, batch_size=4, num_epochs=1000)

estimator.fit(input_fn=input_fn, steps=1000)

print(estimator.evaluate(input_fn=input_fn))
