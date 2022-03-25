import { Text, View, StyleSheet, Image } from 'react-native';
import { Card } from 'react-native-paper';
import Constants from 'expo-constants';
import * as React from 'react';

import Picture from './components/Pikcha';

export default function App() {
  return (
      <View style={styles.container}>
        <Text style={styles.paragraph}>
          Журнал Bright
        </Text>
        <Card style={{borderWidth: 2}}>
          <View style={styles.news}>
            <Text style={styles.blue}>Новости</Text>
          </View>
          <Picture/>
          <View style={styles.buttonContainer}>
            <Text style={styles.next}>
              ЧИТАТЬ ДАЛЕЕ
            </Text>
          </View>
        </Card>
      </View>

  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    backgroundColor: '#ecf0f1',
    paddingTop: Constants.statusBarHeight,
    padding: 8,
  },
  news: {
    marginTop: 10,
    marginLeft: 40
  },
  blue: {
    color: 'blue',
    fontSize: 16,
  },
  next: {
    fontSize: 18,
    fontWeight: 'normal',
    textAlign: 'center',
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  buttonContainer: {
    elevation: 10,
    marginBottom: 20,
    marginHorizontal: 60,
    backgroundColor: '#F0E68C',
    borderRadius: 10,
    padding: 15,
  }
});