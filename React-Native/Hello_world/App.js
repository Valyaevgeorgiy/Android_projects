import * as React from 'react';
import { Text, View, StyleSheet, Image } from 'react-native';
import Constants from 'expo-constants';

const MyFApp = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.paragraph}>
        Hello, world! 
      </Text>
      <Image style={styles.logo} source={require('./assets/snack-icon.png')} />
      <Text style={styles.paragraph}>
        It's my React-native first project in the Expo App!
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  logo: {
    marginRight: 'auto',
    marginLeft: 'auto',
    padding: 24,
    height: 128,
    width: 128
  }
});

export default MyFApp;
