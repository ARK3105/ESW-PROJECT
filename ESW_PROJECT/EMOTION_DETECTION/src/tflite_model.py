import tensorflow as tf
import numpy as np
import cv2
import os

# Load the TFLite model
interpreter = tf.lite.Interpreter(model_path="emotion_model.tflite")
interpreter.allocate_tensors()

# Get input and output tensors
input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()

# Check input details to verify input size
print(f"Input details: {input_details}")
print(f"Output details: {output_details}")

# Load and preprocess an image (48x48 grayscale image)
img_path = "sad_image.jpg"  # Change this to your image path

# Check if the file exists
if not os.path.exists(img_path):
    print(f"Error: The image file at {img_path} does not exist!")
    exit()

# Load the image in grayscale
image = cv2.imread(img_path, cv2.IMREAD_GRAYSCALE)

# Ensure the image was loaded successfully
if image is None:
    print(f"Error: Could not read image from {img_path}")
    exit()

# Resize the image to 48x48 as expected by the model
image_resized = cv2.resize(image, (48, 48))  

# Normalize the image (if the model was trained with normalization)
image_resized = image_resized.astype(np.float32) / 255.0  # Normalize pixel values between 0 and 1

# Add a channel dimension (1 channel for grayscale)
image_resized = np.expand_dims(image_resized, axis=-1)  # Shape (48, 48, 1)

# Add batch dimension (for single image input, batch size is 1)
image_resized = np.expand_dims(image_resized, axis=0)  # Shape (1, 48, 48, 1)

# Set the input tensor to the preprocessed image
interpreter.set_tensor(input_details[0]['index'], image_resized)

# Run inference
interpreter.invoke()

# Get the output from the model
output_data = interpreter.get_tensor(output_details[0]['index'])
print(f"Output data: {output_data}")

# Post-process and get the emotion with the highest probability
emotion_dict = {0: "Angry", 1: "Disgusted", 2: "Fearful", 3: "Happy", 4: "Neutral", 5: "Sad", 6: "Surprised"}

# Get the predicted emotion (the index with the highest score)
predicted_index = np.argmax(output_data)
predicted_emotion = emotion_dict[predicted_index]

print(f"Predicted emotion: {predicted_emotion}")
# import cv2
# import numpy as np
# import tensorflow as tf

# # Load the TFLite model
# interpreter = tf.lite.Interpreter(model_path="emotion_model.tflite")
# interpreter.allocate_tensors()

# # Get input and output details
# input_details = interpreter.get_input_details()
# output_details = interpreter.get_output_details()

# # Function to preprocess input image
# def preprocess_image(image_path):
#     # Step 1: Read the image
#     image = cv2.imread(image_path)

#     # Step 2: Resize the image to 48x48
#     image_resized = cv2.resize(image, (48, 48))

#     # Step 3: Convert the image to grayscale
#     gray_image = cv2.cvtColor(image_resized, cv2.COLOR_BGR2GRAY)

#     # Step 4: Normalize the image by dividing by 255
#     normalized_image = gray_image / 255.0

#     # Step 5: Add batch size and channel dimension
#     # Convert image to (1, 48, 48, 1) for the model
#     input_image = np.expand_dims(normalized_image, axis=-1)  # Add channel dimension
#     input_image = np.expand_dims(input_image, axis=0)  # Add batch size dimension

#     # Convert the input image to float32 (required by TFLite model)
#     input_image = input_image.astype(np.float32)

#     return input_image

# # Path to the image
# image_path = "sad_image.jpg"  # Replace with your image path

# # Preprocess the image
# input_image = preprocess_image(image_path)

# # Step 6: Set the input tensor
# interpreter.set_tensor(input_details[0]['index'], input_image)

# # Step 7: Run the model
# interpreter.invoke()

# # Step 8: Get the output tensor
# output_data = interpreter.get_tensor(output_details[0]['index'])

# # Step 9: Get the predicted emotion
# emotion_dict = {0: "Angry", 1: "Disgusted", 2: "Fearful", 3: "Happy", 4: "Neutral", 5: "Sad", 6: "Surprised"}
# predicted_index = np.argmax(output_data)
# predicted_emotion = emotion_dict[predicted_index]

# # Output the result
# print(f"Predicted emotion: {predicted_emotion}")
