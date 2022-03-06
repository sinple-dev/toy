import { NuxtAxiosInstance } from "@nuxtjs/axios";

declare module "@nuxt/types" {
  interface NuxtAppOptions {
    $axios: NuxtAxiosInstance;
  }
  interface Context {
    $axios: NuxtAxiosInstance;
  }
}

