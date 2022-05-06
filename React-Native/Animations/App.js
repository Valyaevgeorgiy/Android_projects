import Constants from 'expo-constants';
import {
  Animated,
  StyleSheet,
  Text,
  View,
  SafeAreaView,
  ScrollView,
  ImageBackground,
  Button, TouchableOpacity, Easing, Dimensions
} from 'react-native';
import React, {useEffect, useRef} from "react";
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Stack = createNativeStackNavigator();

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

const scrollX = new Animated.Value(0)
const springValue = new Animated.Value(1)
const imageRotateValue = new Animated.Value(0)

const interpolateScrollViewRotation = imageRotateValue.interpolate({
  inputRange: [0, 100],
  outputRange: ["0deg", "360deg"]
})

const images = ["https://picsum.photos/1000/1000?random=2", "https://picsum.photos/1000/1000?random=3", "https://picsum.photos/1000/1000?random=4",
  "https://picsum.photos/1000/1000?random=5", "https://picsum.photos/1000/1000?random=6"]

const flipAnimation = () => {
  Animated.parallel([
      Animated.sequence([
        Animated.spring(springValue, {
          toValue: 0.6,
          friction: 1,
          useNativeDriver: true,
        }),
        Animated.spring(springValue, {
          toValue: 1,
          friction: 1,
          useNativeDriver: true
        })
      ]),
      Animated.sequence([
          Animated.timing(imageRotateValue, {
            toValue: 360,
            duration: 2000,
            useNativeDriver: true,
          }),
          Animated.timing(imageRotateValue, {
            toValue: 0,
            duration: 2000,
            useNativeDriver: true
          })
      ])
  ]).start()
}

const transitionAnimation = (index) => {
  return {
    transform: [
      { perspective: 800 },
      {
        scale: scrollX.interpolate({
          inputRange: [
            (index - 1) * windowWidth,
            index * windowWidth,
            (index + 1) * windowWidth
          ],
          outputRange: [0.25, 1, 0.25]
        })
      },
      {
        rotateX: scrollX.interpolate({
          inputRange: [
            (index - 1) * windowWidth,
            index * windowWidth,
            (index + 1) * windowWidth
          ],
          outputRange: ["45deg", "0deg", "45deg"]
        })
      },
      {
        rotateY: scrollX.interpolate({
          inputRange: [
            (index - 1) * windowWidth,
            index * windowWidth,
            (index + 1) * windowWidth
          ],
          outputRange: ["-45deg", "0deg", "45deg"]
        })
      }
    ]
  };
};

const AnimatedImageCardView = (props) => {
  return (
      <Animated.View style={[styles.scrollPage,
        {transform: [{scale: springValue}, {rotate: interpolateScrollViewRotation}]}]}>
        <Animated.View style={[styles.screen, transitionAnimation(props.index)]}>
          {props.children}
        </Animated.View>
      </Animated.View>
  );
};

const FadeInView = (props) => {
  const fadeAnim = useRef(new Animated.Value(0)).current  // Initial value for opacity: 0

  useEffect( () => {
    Animated.timing(
        fadeAnim,{
          toValue: 1,
          duration: 3000,
          useNativeDriver: true,
        }
    ).start()
  }, [fadeAnim])

  return (
      <Animated.View                 // Special animatable View
          style={{
            ...props.style,
            opacity: fadeAnim,         // Bind opacity to animated value
          }}
      >
        <TouchableOpacity style={{
          backgroundColor: "steelblue",
          height: 50,
          width: windowWidth - 30,
          borderRadius: 15,
          alignItems: "center"}}>
          <Text style={styles.button_text}>
            Галерея
          </Text>
        </TouchableOpacity>
        {props.children}
      </Animated.View>
  );
}

const ScrollViewScreen = () => {
  return (
      <SafeAreaView style={styles.container}>
        <TouchableOpacity style={styles.button}>

        </TouchableOpacity>
        <FadeInView style={styles.scrollContainer}>

          <ScrollView
              horizontal={true}
              style={styles.scrollViewStyle}
              pagingEnabled
              showsHorizontalScrollIndicator={false}
              onScroll={Animated.event([
                {
                  nativeEvent: {
                    contentOffset: {
                      x: scrollX,
                    },
                  },
                },
              ], {useNativeDriver: false})}
              scrollEventThrottle={1}

          >
            {images.map((image, imageIndex) => {
              return (
                  <AnimatedImageCardView
                      key={imageIndex}
                      index={imageIndex}
                  >
                    <ImageBackground source={{ uri: image }} style={styles.card}>
                      <View style={styles.textContainer}>
                        <Text style={styles.infoText}>
                          {"Image - " + imageIndex}
                        </Text>
                      </View>
                    </ImageBackground>
                  </AnimatedImageCardView>
              );
            })}
          </ScrollView>
          <View style={styles.indicatorContainer}>
            {images.map((image, imageIndex) => {
              const width = scrollX.interpolate({
                inputRange: [
                  windowWidth * (imageIndex - 1),
                  windowWidth * imageIndex,
                  windowWidth * (imageIndex + 1)
                ],
                outputRange: [8, 16, 8],
                extrapolate: "clamp"
              });
              return (
                  <Animated.View
                      key={imageIndex}
                      style={[styles.normalDot, { width }]}
                  />
              );
            })}
          </View>
        </FadeInView>
        <View style={{ margin: 30}}>
          <Button title="Анимировать" onPress={flipAnimation} color="black"/>
        </View>
      </SafeAreaView>
  );
}

const LaunchScreen = ({ navigation }) => {
  const rotateValue = useRef(new Animated.Value(0)).current
  const xValue = useRef(new Animated.Value(0)).current

  const interpolateRotation = rotateValue.interpolate({
    inputRange: [0, 100],
    outputRange: ["0deg", "360deg"]
  })

  const moveAndRotateAnimation = () => {
    Animated.parallel([
      Animated.sequence([
        Animated.timing(rotateValue, {
          toValue: 100,
          duration: 2000,
          easing: Easing.linear,
          useNativeDriver: true,
        }),
        Animated.timing(rotateValue, {
          toValue: 0,
          duration: 0,
          useNativeDriver: true,
          easing: Easing.linear,
        }),
      ]),
      Animated.timing(xValue, {
        toValue: windowWidth - 300,
        duration: 500,
        useNativeDriver: true,
        easing: Easing.linear
      }),
    ]).start(() => {
      moveAndRotateAnimation()
    })
  }

  return (
      <View style={styles.container}>
        <Animated.View style={{ margin: 30}}>
          <Animated.Image
              style={{ width: 200, height: 200, alignSelf: "center", margin: 50,
                transform: [{rotate: interpolateRotation}, {translateX: xValue}]}}
              source={require("./assets/aristocratic-now.png")}
              onLoad={() => moveAndRotateAnimation()}
          />
          <TouchableOpacity style={styles.button} onPress={() => navigation.push("Галерея")}>
            <Text style={styles.button_text}>
              Перейти к изображениям
            </Text>
          </TouchableOpacity>
        </Animated.View>
      </View>
  )
}

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Главная страница" component={LaunchScreen} />
        <Stack.Screen name="Галерея" component={ScrollViewScreen} options={{ headerShown: false }}/>
      </Stack.Navigator>
    </NavigationContainer>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: Constants.statusBarHeight,
    alignItems: "center",
    justifyContent: "center"
  },
  fadingContainer: {
    backgroundColor: "powderblue"
  },
  scrollContainer: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center"
  },
  scrollViewStyle: {
    flex: 1,
    backgroundColor:'white',
  },
  screen: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  button: {
    backgroundColor: "olive",
    height: 50,
    marginTop: 80,
    borderRadius: 15,
    alignItems: "center",
  },
  button_text: {
    color: "white",
    padding: 12,
    paddingHorizontal: 20,
    fontWeight: "bold",
    fontSize: 18,
  },
  card: {
    width: windowWidth - 20,
    height: windowHeight / 2,
    borderRadius: 10,
    overflow: "hidden",
    alignItems: "center",
    justifyContent: "center",
  },
  textContainer: {
    backgroundColor: "rgba(0,0,0, 0.7)",
    paddingHorizontal: 24,
    paddingVertical: 8,
    borderRadius: 5
  },
  infoText: {
    color: "white",
    fontSize: 16,
    fontWeight: "bold"
  },
  normalDot: {
    height: 8,
    width: 8,
    borderRadius: 4,
    backgroundColor: "silver",
    marginHorizontal: 4
  },
  scrollPage: {
    width: windowWidth,
    padding: 20,
  },
  indicatorContainer: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    marginBottom: 30,
  },
  outerScroll: {
    flex: 1,
    flexDirection: "column",
  },
  row: {
    flex: 1,
  },
})
