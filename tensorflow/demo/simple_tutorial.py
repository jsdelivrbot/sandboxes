import tensorflow as tf

node1 = tf.constant(3.0, tf.float32)
node2 = tf.constant(4.0) # also tf.float32 implicitly
# prints the node attributes, but not the values.  To get the values, run the computational graph within a session
print(node1, node2)

sess = tf.Session()
print(sess.run([node1, node2]))

node3 = tf.add(node1, node2)
print("node3: ", node3)
print("sess.run(node3): ", sess.run(node3))


a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)
# adder_node is essentially a lambda expression here
adder_node = a + b  # + provides a shortcut for  tf.add(a, b)

# execute the lambda expression to add either single values or arrays of values
print(sess.run(adder_node, {a: 3, b: 4.5}))  # outputs 7.5
print(sess.run(adder_node, {a: [1, 3], b: [2, 4]}))  # outputs [3. 7.]

# add another operation to the computational graph
add_and_triple = adder_node * 3
print(sess.run(add_and_triple, {a: 3, b: 4.5}))

# Variables allow us to add "trainable" parameters to a graph, constructed with a type and an initial value
W = tf.Variable([.3], tf.float32)
b = tf.Variable([-.3], tf.float32)
x = tf.placeholder(tf.float32)
linear_model = W * x + b

init = tf.global_variables_initializer()
sess.run(init)
# prints [ 0.          0.30000001  0.60000002  0.90000004]
print(sess.run(linear_model, {x: [1, 2, 3, 4]}))

# a loss function measures how far apart the current model is from the provided data.  We want the result of
# this value to be minimized.  For this particular case, we will use a standard loss model for linear regression,
# which sums the squares of the deltas between the current model and the provided data
y = tf.placeholder(tf.float32)
squared_deltas = tf.square(linear_model - y)
loss = tf.reduce_sum(squared_deltas)
print("loss value: ", sess.run(loss, {x: [1, 2, 3, 4], y: [0, -1, -2, -3]}))
# 23.66 = sum of square of deltas = (0 - 0) ^ 2 + (0.30000001 + 1) ^ 2 + (0.60000002 + 2) ^ 2 + (0.90000004 + 3) ^ 2

fixW = tf.assign(W, [-1.])
fixb = tf.assign(b, [1.])
sess.run([fixW, fixb])
print("corrected loss value: ", sess.run(loss, {x: [1, 2, 3, 4], y: [0, -1, -2, -3]}))
# corrected loss value = 0.0 once W is set to -1 and b is set to 1, the linear_model will match the provided
# data exactly.  We effectively "guessed" the right model parameters for this simple example, however the main point of
# machine learning is to find the correct model parameters automatically.


# optimizers slowly change each variable in order to minimize the loss function
# the GradientDescent optimizer
optimizer = tf.train.GradientDescentOptimizer(0.01)
train = optimizer.minimize(loss)

sess.run(init)  # reset values to incorrect defaults
for i in range(1000):
    sess.run(train, {x: [1, 2, 3, 4], y: [0, -1, -2, -3]})

print("final, optimized model parameters: ", sess.run([W, b]))
# prints: [array([-0.9999969], dtype=float32), array([ 0.99999082], dtype=float32)] which is essentially
# W = -1, b = 1, which is what we chose for our exact match above




