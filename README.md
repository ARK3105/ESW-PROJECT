# ESW-PROJECT


### Team Name - Jarvis 

# Crowd Monitoring System

**Team Members**  
- Sanyam Agrawal (2023101038)  
- Ansh Archarya (2023101069)  
- Nidhish Jain (2023101071)  
- Atharva Kulkarni (2023101072)  

---

## Project Aim  
Develop a crowd monitoring application using the QIDK to detect and monitor emotions of people

---

## Objectives  
1. **Sensor Integration**  
   Integrate sensors (mainly cameras) provided with the QIDK to detect and monitor people in a specified area.  

2. **Person Count**  
   Implement real-time person counting and display the results.  

3. **Emotion Detection**  
   Use a model to identify emotions (e.g., Happy, Sad, Neutral, Angry, Fearful) and display results.  

4. **Server Integration**  
   Develop a networking mechanism to send post-processed data to a central server for displaying real-time crowd information.  

5. **Power Efficiency**  
   Optimize the system for low power consumption, switching between models based on battery and CPU usage.  

---

## Work Done  
- Shifted to TensorFlow Lite models for object detection.  
- Modified the model to detect only persons and count them in real time.  
- Integrated an emotion detection model for detailed emotional analysis.  
- Developed a server integration to display live data (demonstrated using a laptop).  

---

## Challenges Faced  
1. Qualcomm model failed to generate object-detection boxes on QIDK.  
2. TensorFlow Lite struggled with accuracy in larger crowds.  
3. Integrating object detection with emotion detection models was complex.  
4. Finding a compatible emotion detection model was tedious.  

---

## Future Improvements  
1. Train the TensorFlow Lite model to exclusively detect humans for better performance.  
2. Improve scalability for larger crowd monitoring.  

---

## Final Deliverable  
A fully functioning crowd monitoring system using QIDK with a real-time user interface connected to a central server.  

---

## Individual Contributions  
- **Sanyam Agrawal**  
  Initial testing of YOLO NAS and DETR, implementing the server, and searching for compatible emotion detection models.  
- **Ansh Archarya**  
  Initial testing of YOLO NAS and DETR, and integrating emotion detection models with object detection.  
- **Nidhish Jain**  
  Initial testing of YOLO NAS and DETR, searching and testing emotion detection models, and integration.  
- **Atharva Kulkarni**  
  Initial testing of YOLO NAS and DETR, and testing and integrating compatible emotion detection models.  

--- 

This README provides a summary of the project's objectives, progress, challenges, and outcomes.
