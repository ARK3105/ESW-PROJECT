import h5py

with h5py.File('model.h5', 'r') as f:
    # Print layer names
    for layer in f.attrs['layer_names']:
        print(layer)
    # Print details for each layer
    for layer in f['model_weights']:
        print(layer.name, layer.keys())
    